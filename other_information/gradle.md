println("1Common Project targetSdkVersion: " + project.targetSdkVersion)
println("2Common Project targetSdkVersion: $project.targetSdkVersion")
println "3Common Project targetSdkVersion:  ${project.targetSdkVersion}"
println "4Common Project targetSdkVersion: $project.targetSdkVersion"
project.logger.debug("5Common Project targetSdkVersion: $project.targetSdkVersion")
project.logger.debug("6Common Project targetSdkVersion: ${project.targetSdkVersion}")



Properties props = new Properties()
InputStream ins = new FileInputStream("/project_credentials/credentials.properties")
props.load(ins)
ins.close()


println "Module AbsolutePath: ${new File(project.projectDir.getAbsolutePath())}"


    println "projectDir:   ${project.projectDir}"
    println "project dir:  ${System.getProperty("user.dir")}"

    println "User Dir: ${System.getProperty('user.dir')}"

    System.setProperty("user.dir", project.projectDir.toString())
    println "project dir:  " + System.getProperty("user.dir")



    try {
//            File ff = file("${project.rootDir}/project_credentials/credentials.properties")
File ff = file("../project_credentials/credentials.properties")
//            File ff = file("../temp.properties")
println "ff path: ${ff.toString()}"

        if (ff.exists()) println "ff file exists"
        else println "ff file not exists"


        InputStream ins = new FileInputStream("${ff.absolutePath}")
        props.load(ins)
        ins.close()

//            props.load(ff)
println "User Dir: ${props.getProperty("MY_NAME")}"
} catch (Exception ignored) {
throw new GradleException("Missing credentials.properties file.\n${ignored}");
}