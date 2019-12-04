 #!/usr/bin/bash
 
exec scala "$0" "$@"
!#
object HelloWorld {
    def main(args: Array[String]):Unit = {
	println("Hello, world! " + args.toList)
    }
}
HelloWorld.main(args)
