package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class HomeFoodGateKeeperService extends Controller {

    public static Result index() {
        return ok(index.render());
    }
    
    public static Result listRecipe() {
        return ok(listing.render());
    }
    
    public static Result signup(){
    	return ok(signup.render());
    }

}
