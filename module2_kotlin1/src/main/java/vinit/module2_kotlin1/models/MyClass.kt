package vinit.module2_kotlin1.models

class MyClass {

}



data class Student(var id :Int , var name:String , var location:String){
}


fun main() {
    val obj  = listOf(
        Student(1 , "Ram","Delhi"),
        Student(2 , "Sham","Lucknow"),
        Student(3 , "Rohan" , "Delhi"),
        Student(4 , "Ramesh" ,"Pune"),
        Student(5,"Mahesh","Delhi")
    )

    val filteredData = obj.filter { pt -> pt.location == "Delhi" }
    println("${filteredData}")


    val res = obj.groupBy{it.location}.filterValues { it.size > 1 }.values.firstOrNull()



    println("1->>> ${obj.groupBy{it.location}}")
    println("2->>> $res")
    println("3->>> ${obj.groupBy { it.location }.filter { it.value.size >1 }.flatMap { it.value }}")
}