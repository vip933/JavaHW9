package program.serializableObjectsExamples;

import program.JsonSerializerLibrary.annotations.*;

@JsonSerializable
public final class Person {

    @JsonElement
    private String firstName;

    @JsonElement(name = "Name")
    private String lastName;

    @JsonElement()
    private String age;

    private String weight;

    public Person(String firstName, String lastName, String age, String weight) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAge() {
        return age;
    }

    public String getWeight() {
        return weight;
    }
}
