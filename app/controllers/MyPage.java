package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import securesocial.core.Identity;
import securesocial.core.java.SecureSocial;

public class MyPage extends Controller {

    @SecureSocial.SecuredAction
    public static Result index() {
        Identity user = (Identity) ctx().args.get(SecureSocial.USER_KEY);
        return ok("OK");
    }

    @SecureSocial.UserAwareAction
    public static Result userAware() {
        Identity user = (Identity) ctx().args.get(SecureSocial.USER_KEY);
        final String userName = user != null ? (String) user.fullName() : "guest";
        return ok("Hello " + userName);
    }

    @SecureSocial.SecuredAction(ajaxCall = true)
    public static Result ajaxCall() {
        return ok("ok");
    }
}
