package com.bmuschko.jenkins

class Gradle implements Serializable {
    def steps

    Gradle(steps) {
        this.steps = steps
    }
    
    def wrapper(String... args) {
        if (isUnix()) {
            steps.sh "./gradlew ${args.join(' ')} -s"
        } else {
            steps.bat "gradlew.bat ${args.join(' ')} -s"
        }
    }
}