package de.hkokocin.exercise_service.generators

import de.hkokocin.exercise_service.ProblemDefinition

class ProblemGenerator(
    private val additionGenerator: AdditionGenerator,
    private val subtractionGenerator: SubtractionGenerator,
    private val multiplicationGenerator: MultiplicationGenerator,
    private val divisionGenerator: DivisionGenerator,
    private val reverseAdditionGenerator: ReverseAdditionGenerator,
    private val reverseSubtractionGenerator: ReverseSubstractionGenerator,
    private val reverseMultiplicationGenerator: ReverseMultiplicationGenerator
) {
    fun create(definitions: List<ProblemDefinition>) = when (val definition = definitions.random()) {
        is ProblemDefinition.Numeric.Addition -> additionGenerator.create(definition)
        is ProblemDefinition.Numeric.Subtraction -> subtractionGenerator.create(definition)
        is ProblemDefinition.Numeric.Multiplication -> multiplicationGenerator.create(definition)
        is ProblemDefinition.Numeric.Division -> divisionGenerator.create(definition)
        is ProblemDefinition.Numeric.ReverseAddition -> reverseAdditionGenerator.create(definition)
        is ProblemDefinition.Numeric.ReverseSubtraction -> reverseSubtractionGenerator.create(definition)
        is ProblemDefinition.Numeric.ReverseMultiplication -> reverseMultiplicationGenerator.create(definition)
        is ProblemDefinition.ReverseDivision -> TODO()
    }
}
