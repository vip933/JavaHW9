package program.serializableObjectsExamples;

import program.JsonSerializerLibrary.annotations.*;

@IgnoreNull
@JsonSerializable
public class Car {

    @JsonElement
    protected String manufacturer;

    @JsonElement
    protected String modelName;

    @JsonElement
    protected int horsePowers;

    public Car(String manufacturer, String modelName, int horsePowers) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.horsePowers = horsePowers;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getHorsePowers() {
        return horsePowers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", horsePowers=" + horsePowers +
                '}';
    }
}
