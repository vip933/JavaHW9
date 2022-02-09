package program.serializableObjectsExamples;

import program.JsonSerializerLibrary.annotations.*;

@IgnoreNull
@JsonSerializable
public class SportCar extends Car {

    @JsonElement
    private double streamliningCoefficient;

    public SportCar(String manufacturer, String modelName, int horsePowers) {
        super(manufacturer, modelName, horsePowers);
    }

    public SportCar(String manufacturer, String modelName, int horsePowers, double streamliningCoefficient) {
        super(manufacturer, modelName, horsePowers);
        this.streamliningCoefficient = streamliningCoefficient;
    }

    public double getStreamliningCoefficient() {
        return streamliningCoefficient;
    }

    @Override
    public String toString() {
        return "SportCar{" +
                "manufacturer='" + manufacturer + '\'' +
                ", modelName='" + modelName + '\'' +
                ", horsePowers=" + horsePowers + '\'' +
                ", streamliningCoefficient=" + streamliningCoefficient +
                '}';
    }
}
