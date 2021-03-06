/**
 * Created by james on 2/4/17.
 */
package com.mccodecraft.Website.pages;

import com.mccodecraft.Website.Dao.ParentMySQLDao;
import com.mccodecraft.Website.Dao.StudentMySQLDao;
import com.mccodecraft.Website.DbObjects.Parent;
import com.mccodecraft.Website.DbObjects.Student;
import com.mccodecraft.Website.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import spark.Request;
import spark.Response;
import spark.template.freemarker.FreeMarkerRoute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;

public class WebsiteLanding {

    public static ParentMySQLDao<Parent> parentDbService = new ParentMySQLDao<>();
    public static StudentMySQLDao<Parent, Student> studentDbService = new StudentMySQLDao<>();

    public static void main(String[] args) {


        get(new FreeMarkerRoute("/parentInfo/display/:id") {
            @Override
            public Object handle(Request request, Response response) {
                Integer id = Integer.parseInt(request.params(":id"));
                Parent parent = parentDbService.read(id);
                Map<String, Object> viewObjects = new HashMap<>();

                viewObjects.put("templateName", "parentInfoForm.ftl");

                viewObjects.put("article", parentDbService.read(id));
                return modelAndView(viewObjects, "layout.ftl");
            }
        });


        get(new FreeMarkerRoute("/") {
            @Override
            public Object handle(Request request, Response response) {
                Map<String, Object> viewObjects = new HashMap<>();

                // wiring into insert,
                Parent parent = null;
                Integer newID = 0;
//                newID = studentDbService.create(parent, student);



                SessionFactory sessionFactory = null;
                Session session = null;
                Transaction tx = null;

                sessionFactory = HibernateUtil.getSessionFactory();
                session = sessionFactory.openSession();
                System.out.println("Session created");

                try {
                    tx = session.beginTransaction();

                    List<Student> studentList = new ArrayList<>();

                    Student student = new Student()
                            .setfName("studentFirstName")
                            .setlName("studentLastName")
                            .setpName("bossCraft")
                            .setpWord("studentPass");
                    studentList.add(student);


                    parent = new Parent()
                            .setfName("firstAfterUpdate")
                            .setlName("lastname")
                            .setpName("person?name")
                            .setpWord("password")
                            .setStudents(studentList);
                    session.save(parent);

                    tx.commit();

                } catch (Exception e) {
                    System.out.println("Exception occured. " + e.getMessage());
                    e.printStackTrace();
                    tx.rollback();
                } finally {
                    if (!sessionFactory.isClosed()) {
                        System.out.println("Closing SessionFactory");
                        sessionFactory.close();
                    }
                }

                if (null == newID) {
                    viewObjects.put("hasNoParents", "Welcome, please click \"Write Parent\" to begin.");
                } else {
//                    Deque<Parent> showParents = new ArrayDeque<>();

                    viewObjects.put("hasParents", "Awesome, you created parent with parent id of :" + newID);
                }
                viewObjects.put("templateName", "index.ftl");
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
