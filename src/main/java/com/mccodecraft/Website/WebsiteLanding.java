/**
 * Created by james on 2/4/17.
 */
package com.mccodecraft.Website;

import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.template.freemarker.FreeMarkerRoute;

import java.util.*;

import static spark.Spark.get;
import static spark.Spark.post;

public class WebsiteLanding {

    public static ParentDbService<Parent> parentDbService = new ParentServletDao<>();

    public static void main(String[] args) {
        get(new FreeMarkerRoute("/") {
            @Override
            public ModelAndView handle(Request request, Response response) {
                Map<String, Object> viewObjects = new HashMap<>();
                Parent parent = ParentDbService.read(1);

                if (null == parent) {
                    viewObjects.put("hasNoParents","Welcome, please click \"Write Parent\" to begin.");
                } else {
                    Deque<Parent> showParents = new ArrayDeque<>();

                    viewObjects.put("parentInfo", showParents);
                }
                viewObjects.put("templateName", "articleList.ftl");
                return modelAndView(viewObjects, "layout.ftl");
            }
        });

//        get(new FreeMarkerRoute("/parentInfo/create") {
//            @Override
//            public Object handle(Request request, Response response) {
//                Map<String, Object> viewObjects = new HashMap<>();
//                viewObjects.put("templateName", "articleForm.ftl");
//
//                return modelAndView(viewObjects, "layout.ftl");
//            }
//        });
//
//        post(new FreeMarkerRoute("/parentInfo/create") {
//            @Override
//            public Object handle(Request request, Response response) {
//                String title = request.queryParams("article-title");
//                String summary = request.queryParams("article-summary");
//                String content = request.queryParams("article-content");
//
//                Parent article = new Parent(title, summary, content, articleParentDbService.readAll().size(), new Date(), false);
//
//                articleParentDbService.create(article);
//
//                response.status(201);
//                response.redirect("/");
//                return "";
//            }
//        });
//
//        get(new FreeMarkerRoute("/parentInfo/display/:id") {
//            @Override
//            public Object handle(Request request, Response response) {
//                Integer id = Integer.parseInt(request.params(":id"));
//                Map<String, Object> viewObjects = new HashMap<>();
//
//                viewObjects.put("templateName", "articleRead.ftl");
//
//                viewObjects.put("article",articleParentDbService.readOne(id));
//                return modelAndView(viewObjects, "layout.ftl");
//            }
//        });
//
//        get(new FreeMarkerRoute("/parentInfo/update/:id") {
//            @Override
//            public Object handle(Request request, Response response) {
//                Integer id = Integer.parseInt(request.params(":id"));
//                Map<String, Object> viewObjects = new HashMap<>();
//                viewObjects.put("templateName", "articleForm.ftl");
//
//                viewObjects.put("article", articleParentDbService.readOne(id));
//                return modelAndView(viewObjects, "layout.ftl");
//            }
//        });
//
//        post(new Route("/parentInfo/update/:id") {
//            @Override
//            public Object handle(Request request, Response response) {
//                Integer id      = Integer.parseInt(request.queryParams("article-id"));
//                String title    = request.queryParams("article-title");
//                String summary  = request.queryParams("article-summary");
//                String content  = request.queryParams("article-content");
//                Date date = new Date();
//                Boolean delete = false;
//
//                articleParentDbService.update(id, title, summary, content, date, delete);
//                response.status(200);
//                response.redirect("/");
//                return "";
//            }
//        });
//
//        get(new Route("/parentInfo/delete/:id") {
//            @Override
//            public Object handle(Request request, Response response) {
//                Integer id = Integer.parseInt(request.params(":id"));
//                articleParentDbService.delete(id);
//
//                response.status(200);
//                response.redirect("/");
//                return "";
//            }
//        });
    }
}
