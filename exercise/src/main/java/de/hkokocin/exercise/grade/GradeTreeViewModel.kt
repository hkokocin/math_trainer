package de.hkokocin.exercise.grade

import de.blox.graphview.Graph
import de.blox.graphview.Node
import de.hkokocin.android.startActivity
import de.hkokocin.exercise.grade.GradeTreeViewState.UpdateGraph
import de.hkokocin.exercise.lesson.LessonActivity
import de.hkokocin.exercise_service.ExercisesRepository
import de.hkokocin.exercise_service.LessonDefinition
import de.hkokocin.local_data.LocalScoreRepository
import de.hkokocin.redukt.Action
import de.hkokocin.redukt.CompositeViewModel
import de.hkokocin.redukt.ViewModelShard
import de.hkokocin.toolkit.coroutines.Jobs

class GradeTreeViewModel(shard: GradeTreeViewModelShard) : CompositeViewModel<GradeTreeViewState>(shard)

class GradeTreeViewModelShard(
    private val exercisesRepository: ExercisesRepository,
    private val scoreRepository: LocalScoreRepository,
    private val jobs: Jobs
) : ViewModelShard<GradeTreeViewState>() {

    override fun dispatch(action: Action) {
        when (action) {
            is ViewCreated -> loadGraph()
        }
    }

    private fun loadGraph() = jobs.launch {
        val definitions = exercisesRepository
            .getLessonDefinitions()
            .await()

        val nodes = definitions
            .map { it.id to Node(it.toNodeState()) }
            .toMap()

        val graph = Graph()
        nodes.values.forEach {
            graph.addNode(it)
        }

        definitions.forEach { definition ->
            val node = nodes[definition.id] ?: return@launch
            definition.dependsOn.forEach {
                val sourceNode = nodes[it] ?: return@launch
                graph.addEdge(sourceNode, node)
            }
        }

        emit(UpdateGraph(graph))
    }

    private fun LessonDefinition.toNodeState() = LessonNodeViewState(
        title,
        scoreRepository.getLowestHighscore(exercises.map { it.id })
    ) { emit(GradeTreeViewState.Command(onLessonSelected(this))) }

    private fun onLessonSelected(lesson: LessonDefinition) = startActivity<LessonActivity> {
        putExtra(LessonActivity.EXTRA.LESSON_ID, lesson.id)
    }
}

@Suppress("UNCHECKED_CAST")
private fun <T> Any?.cast(): T? = this as? T
