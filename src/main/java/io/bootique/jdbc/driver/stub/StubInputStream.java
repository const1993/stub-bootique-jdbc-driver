package io.bootique.jdbc.driver.stub;

import java.io.IOException;
import java.io.InputStream;

public class StubInputStream extends InputStream {
    @Override
    public int read() throws IOException {
        return 0;
    }
}
