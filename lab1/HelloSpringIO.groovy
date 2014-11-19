@RestController
class HelloSpringIO {

    @RequestMapping('/')
    def greet() {
        'Hello Spring IO!'
    }
}
