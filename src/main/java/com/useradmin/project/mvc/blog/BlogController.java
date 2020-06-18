package com.useradmin.project.mvc.blog;

import com.demo.common.model.Blog;
import com.jfinal.aop.Before;
import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import live.autu.plugin.jfinal.swagger.annotation.Api;
import live.autu.plugin.jfinal.swagger.annotation.ApiImplicitParam;
import live.autu.plugin.jfinal.swagger.annotation.ApiImplicitParams;
import live.autu.plugin.jfinal.swagger.annotation.ApiOperation;
import live.autu.plugin.jfinal.swagger.config.RequestMethod;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: http://jfinal.com/club
 * <p>
 * 所有 sql 与业务逻辑写在 Service 中，不要放在 Model 中，更不
 * 要放在 Controller 中，养成好习惯，有利于大型项目的开发与维护
 */
@Api(tags = "test", description = "测试")
@Before(BlogInterceptor.class)
public class BlogController extends Controller {

    @Inject
    BlogService service;

    @ApiOperation(methods=RequestMethod.GET)
    @ApiImplicitParams({
            @ApiImplicitParam(name="userName",required=false,description="这是学员的姓名")
    })
    public void index() {
        setAttr("blogPage", service.paginate(getParaToInt(0, 1), 10));
        render("/wp/view/blog/blog.html");
    }

    public void add() {
        render("/wp/view/blog/add.html");
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 service 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void save() {
        getBean(Blog.class).save();
        redirect("/blog");
    }

    public void edit() {
        setAttr("blog", service.findById(getParaToInt()));
        render("/wp/view/blog/edit.html");
    }

    /**
     * save 与 update 的业务逻辑在实际应用中也应该放在 service 之中，
     * 并要对数据进正确性进行验证，在此仅为了偷懒
     */
    @Before(BlogValidator.class)
    public void update() {
        getBean(Blog.class).update();
        redirect("/blog");
    }

    public void delete() {
        service.deleteById(getParaToInt());
        redirect("/blog");
    }

    @ApiOperation(methods=RequestMethod.GET)
    @ApiImplicitParams({
        @ApiImplicitParam(name="userName",required=false,description="这是学员的姓名")
    })
    public void test() {
        renderJson();
    }

}
