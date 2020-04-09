package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.ProblemDefinition

class ProblemGenerator(
    private val additionGenerator: AdditionGenerator,
    private val substractionGenerator: SubstractionGenerator,
    private val multiplicationGenerator: MultiplicationGenerator,
    private val reverseAdditionGenerator: ReverseAdditionGenerator,
    private val reverseSubstractionGenerator: ReverseSubstractionGenerator,
    private val reverseMultiplicationGenerator: ReverseMultiplicationGenerator
) {
    fun create(definitions: List<ProblemDefinition>) = when (val definition = definitions.random()) {
        is ProblemDefinition.Addition -> additionGenerator.create(definition)
        is ProblemDefinition.Subtraction -> substractionGenerator.create(definition)
        is ProblemDefinition.Multiplication -> multiplicationGenerator.create(definition)
        is ProblemDefinition.ReverseAddition -> reverseAdditionGenerator.create(definition)
        is ProblemDefinition.ReverseSubtraction -> reverseSubstractionGenerator.create(definition)
        is ProblemDefinition.ReverseMultiplication -> reverseMultiplicationGenerator.create(definition)
    }
}
