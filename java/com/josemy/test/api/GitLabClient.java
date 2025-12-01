package api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GitLabClient {

    private static final String GITLAB_URL = "https://api.gitlab.com/";
    private static final String TOKEN = "sdfñalsdjfkl";

    public static List<Project> getAll() throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(GITLAB_URL + "/api/v4/projects"))
                .header("PRIVATE-TOKEN", TOKEN)
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        //Parse JSON response
//        ObjectMapper mapper = new ObjectMapper();
//        JsonNode root = mapper.readTree(response.body());
//
//        List<Project> projects = new ArrayList<>();
//        for (JsonNode node : root) {
//            Project project = new Project();
//            project.name = node.get("name").asText();
//
//            if (node.has("namespace") && !node.get("namespace").isNull()) {
//                Namespace namespace = new Namespace();
//
//                namespace.id = node.get("namespace").get("id").asText();
//                namespace.name = node.get("namespace").get("name").asText();
//                project.namespace = namespace;
//            }
//
//            projects.add(project);
//        }
//
//        //Print projects
//        projects.forEach(p -> System.out.println(p.name));
//
//        return projects;
        return null;
    }

    public static List<Project> orderByName(List<Project> projects) {
        //Lambda
        projects.sort((o1, o2) -> o1.name.compareToIgnoreCase(o2.name));


        // Option 2. With comparator
//        projects.sort(Comparator.comparing(project -> project.name, String.CASE_INSENSITIVE_ORDER));

        return projects;
    }

    public static Map<Integer, List<Project>> grooupByNamespace(List<Project> projects) {

        Map<Integer, List<Project>> grouped = new HashMap<>();

        projects.forEach(project -> {
            List<Project> groupedProjects = grouped.getOrDefault(project.namespace.id, null);
            if (groupedProjects == null) {
                groupedProjects = new ArrayList<>();
                grouped.put(project.namespace.id, groupedProjects);
            }
            groupedProjects.add(project);
        });

        //Option 2. Streams
        projects.stream()
                .filter(p -> p.namespace != null)  // Handle null namespaces
                .collect(Collectors.groupingBy(project -> project.namespace.id));

        return grouped;
    }

}
