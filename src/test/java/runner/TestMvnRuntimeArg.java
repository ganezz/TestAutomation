package runner;

import org.junit.Test;
import testMethods.ArgumentsMvn;

import java.io.IOException;

public class TestMvnRuntimeArg {
    ArgumentsMvn argumentsMvn = new ArgumentsMvn();

    @Test
    public void exeTest() throws IOException {
        argumentsMvn.prop();
    }
}
