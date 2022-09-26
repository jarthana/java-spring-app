package application.rest.v1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v1")
public class Example {


    @GetMapping
    @Operation(summary = "Get status of application")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Confirmation message that application is running",
                            content = @Content(mediaType = "text/plain"),
                            headers = {
                            		@Header(name = "X-Content-Type-Options",
                            				schema =
                            		          @Schema(type = "string"),
                            		          description = ""),
                            		@Header(name = "X-Frame-Options",
                    					schema =
                    						@Schema(type = "string"),
                    						description = "")
                            })
            }
    )
    public @ResponseBody ResponseEntity<String> example() {
        List<String> list = new ArrayList<>();
        //return a simple list of strings
        list.add("Congratulations, your application is up and running");
        ResponseEntity<String> resp = new ResponseEntity<>(list.toString(), HttpStatus.OK);
        resp.getHeaders().add("X-Content-Type-Options", "nosniff");
        resp.getHeaders().add("X-Frame-Options", "");
        return new ResponseEntity<String>(list.toString(), HttpStatus.OK);
    }

}
