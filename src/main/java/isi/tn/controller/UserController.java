
package isi.tn.controller;

        import isi.tn.entities.User;
        import isi.tn.service.ImpluserService;
        import isi.tn.service.IuserService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import javax.validation.Valid;
        import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final ImpluserService userService;

    @Autowired
    public UserController(ImpluserService userService) {
        this.userService = userService;
    }


    @PutMapping("/user/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable Long userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @PatchMapping("/user/{userId}")
    public ResponseEntity<User> patchUser(@PathVariable Long userId, @RequestBody User user) {
        User patchedUser = userService.patchUser(userId, user);
        return new ResponseEntity<>(patchedUser, HttpStatus.OK);
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        List<User> user = userService.findAllUsers();
        return user;

    }

    @PostMapping("/adduser")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);

        return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
    }

}
