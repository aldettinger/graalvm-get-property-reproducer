package org.acme;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

@QuarkusMain
public class Main {

    public static void main(String... args) throws ReflectiveOperationException {
        // Reproduces the "Unsupported features in 4 methods"
        DynamicType.Builder<?> builder = new ByteBuddy().subclass((Class<?>)null);
        builder.make().load(null, ClassLoadingStrategy.Default.WRAPPER).getLoaded();

        Quarkus.run(args);
    }
}
