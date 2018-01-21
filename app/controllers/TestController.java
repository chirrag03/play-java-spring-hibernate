package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import configs.Global;
import models.entities.Test;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import services.TestService;
import java.util.List;

public class TestController extends Controller{

    TestService testService = Global.getBean(TestService.class);

    public Result getAll() {
        List<Test> entityList = testService.list();
        return ok(Json.toJson(entityList));
    }

    public Result get(int id) {
        try {
            Test entity = testService.find(id);
            return ok(Json.toJson(entity));
        } catch (Exception ex) {
            return notFound(ex.getMessage());
        }
    }

    public Result create() {
        try {
            JsonNode jsonNode = request().body().asJson();
            Test entity = testService.save(jsonNode);
            return ok(Json.toJson(entity));
        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }
    }

    public Result update() {
        try {
            JsonNode jsonData = request().body().asJson();
            Test entity = testService.edit(jsonData);
            return ok(Json.toJson(entity));
        } catch (Exception ex) {
            return badRequest(ex.getMessage());
        }
    }

    public Result remove(int id){
        try {
            testService.remove(id);
            return ok();
        } catch (Exception ex) {
            return notFound(ex.getMessage());
        }
    }
}
