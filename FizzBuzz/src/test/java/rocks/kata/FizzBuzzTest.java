package rocks.kata;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.api.extension.TestTemplateInvocationContext;
import org.junit.jupiter.api.extension.TestTemplateInvocationContextProvider;

public class FizzBuzzTest {

    @TestTemplate
    @ExtendWith(FizzBuzzTestInvocationContextProvider.class)
    public void FizzBuzzTestTemplate(FizzBuzzTestCase testCase) {
        // Test checking if method getFizzBuzzOrNumber returns correct String for given
        // number
        String result = testCase.fizzBuzzInstance.getFizzBuzzOrNumber(testCase.testedNumber);
        assertTrue(testCase.expectedResult.equals(result));
    }

    static private class FizzBuzzTestCase {
        private String description;
        private int testedNumber;
        private FizzBuzz fizzBuzzInstance;
        private String expectedResult;

        public FizzBuzzTestCase(String description, int testedNumber, FizzBuzz fizzBuzzInstance,
                String expectedResult) {
            this.description = description;
            this.testedNumber = testedNumber;
            this.fizzBuzzInstance = fizzBuzzInstance;
            this.expectedResult = expectedResult;
        }

    }

    static private class FizzBuzzTestCasesFactory {

        private static List<FizzBuzzTestCase> createTestCases() {
            List<FizzBuzz> listOfFizzBuzzObjects = Arrays.asList(
                    new FizzBuzzDivisibilityRules(),
                    new FizzBuzzLiterals(),
                    new FizzBuzzModulo(),
                    new FizzBuzzPattern());
            List<Integer> listOfNumbersDivisibleBy3 = Arrays.asList(3, 12, 3 * 100003);
            List<Integer> listOfNumbersDivisibleBy5 = Arrays.asList(5, 25, 5 * 100003);
            List<Integer> listOfNumbersDivisibleBy15 = Arrays.asList(15, 15 * 15, 15 * 100003);
            List<Integer> listOfNumbersNotDivisibleBy3or5 = Arrays.asList(2, 19, 100003);

            List<FizzBuzzTestCase> testCases = new ArrayList<>();

            for (FizzBuzz fizzBuzzObject : listOfFizzBuzzObjects) {
                for (int number : listOfNumbersDivisibleBy3) {
                    testCases.add(createFizzBuzzTestCase(number, fizzBuzzObject, "Fizz"));
                }
                for (int number : listOfNumbersDivisibleBy5) {
                    testCases.add(createFizzBuzzTestCase(number, fizzBuzzObject, "Buzz"));
                }
                for (int number : listOfNumbersDivisibleBy15) {
                    testCases.add(createFizzBuzzTestCase(number, fizzBuzzObject, "FizzBuzz"));
                }
                for (int number : listOfNumbersNotDivisibleBy3or5) {
                    testCases.add(createFizzBuzzTestCase(number, fizzBuzzObject, Integer.toString(number)));
                }

            }
            return testCases;
        }

        private static FizzBuzzTestCase createFizzBuzzTestCase(int number, FizzBuzz fizzBuzzInstance,
                String expectedResult) {
            return new FizzBuzzTestCase(generateTestDescription(fizzBuzzInstance, number), number, fizzBuzzInstance,
                    expectedResult);
        }

        private static String generateTestDescription(FizzBuzz fizzBuzzObject, int number) {
            return "Object " + fizzBuzzObject.getClass().getSimpleName() + " and number " + number;
        }
    }

    static private class FizzBuzzTestCaseParameterResolver implements ParameterResolver {

        private FizzBuzzTestCase testCase;

        private FizzBuzzTestCaseParameterResolver(FizzBuzzTestCase testCase) {
            this.testCase = testCase;
        }

        @Override
        public Object resolveParameter(ParameterContext arg0, ExtensionContext arg1)
                throws ParameterResolutionException {

            return testCase;
        }

        @Override
        public boolean supportsParameter(ParameterContext arg0, ExtensionContext arg1)
                throws ParameterResolutionException {

            return arg0.getParameter().getType() == FizzBuzzTestCase.class;
        }

    }

    static private class FizzBuzzTestInvocationContextProvider implements TestTemplateInvocationContextProvider {

        @Override
        public boolean supportsTestTemplate(ExtensionContext arg0) {
            return true;
        }

        @Override
        public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(
                ExtensionContext extensionContext) {

            List<FizzBuzzTestCase> testCases = FizzBuzzTestCasesFactory.createTestCases();

            return testCases.stream().map(testCase -> new TestTemplateInvocationContext() {
                @Override
                public String getDisplayName(int invocationIndex) {
                    return testCase.description;
                }

                @Override
                public List<Extension> getAdditionalExtensions() {
                    return Arrays.asList(
                            new FizzBuzzTestCaseParameterResolver(testCase));
                }
            });

        }

    }

}
