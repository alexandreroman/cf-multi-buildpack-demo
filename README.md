# Cloud Foundry Multi-buildpack Demo

This project shows how to use the multi-buildpack feature for
Cloud Foundry apps.

Using multi-buildpack is as easy as adding a reference to a buildpack
in the app manifest:

```yaml
---
applications:
  - name: cf-multi-buildpack-demo
    path: target/cf-multi-buildpack-demo.jar
    memory: 1G
    random-route: true
    buildpacks:
      - https://github.com/alexandreroman/hello-buildpack.git
      - https://github.com/cloudfoundry/java-buildpack.git

```

Buildpacks order is important: the last one is responsible for
running the application once deployed to Cloud Foundry.

This project is using the
[Cloud Foundry Java Buildpack](https://github.com/cloudfoundry/java-buildpack)
to run a Java Spring Boot app. In the app manifest, you can enable an additional
buildpack, [Hello Buildpack](https://github.com/alexandreroman/hello-buildpack),
which adds a single file in the container filesystem for demonstration purposes.

You could easily create your own buildpack to customize your app container:
 - add JDBC driver
 - add custom certificates
 - add mçnitoring agents
 - etc.

## How to use it?

Compile this project using Maven and a JDK 8:
```shell
$ ./mvnw clean package
```

Deploy this app to your Cloud Foundry foundation:
```shell
$ cf push
```

Go to http://localhost:8080:
a page will show you if the `Hello Buildpack` is installed or not.

Update the app manifest to enable the `Hello Buildpack`.

## Contribute

Contributions are always welcome!

Feel free to open issues & send PR.

## License

Copyright &copy; 2018 Pivotal Software, Inc.

This project is licensed under the [Apache Software License version 2.0](https://www.apache.org/licenses/LICENSE-2.0).
