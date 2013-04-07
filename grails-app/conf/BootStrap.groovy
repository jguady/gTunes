import grails.util.Environment

import com.gtunes.User

class BootStrap {

    def init = { servletContext ->
		switch (Environment.current) {
			case Environment.DEVELOPMENT:
			
			def user = new User(login:'jguady',password:'password',firstName:'Jay',lastName:'Guady').save()
			
			
			break;
		
		}
    }
    def destroy = {
    }
}
