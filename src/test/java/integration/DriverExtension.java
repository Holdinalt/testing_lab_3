package integration;

import org.junit.jupiter.api.extension.*;

public class DriverExtension implements BeforeAllCallback, ParameterResolver {

    String browser;

    @Override
    public void beforeAll(ExtensionContext context){
        browser = context.getConfigurationParameter("browser").orElse(null);
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(String.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return browser;
    }
}
