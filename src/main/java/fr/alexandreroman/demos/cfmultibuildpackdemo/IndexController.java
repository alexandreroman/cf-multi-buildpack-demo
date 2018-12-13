/*
 * Copyright (c) 2018 Pivotal Software, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.alexandreroman.demos.cfmultibuildpackdemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index(Map<String, Object> model) throws IOException {
        final Path p = FileSystems.getDefault().getPath("/home/vcap/app/hello.txt");
        final boolean buildpackInstalled =
                Files.exists(p) && Files.readAllLines(p).contains("Hello world!");
        model.put("buildpackInstalled", buildpackInstalled);

        return "index";
    }
}
