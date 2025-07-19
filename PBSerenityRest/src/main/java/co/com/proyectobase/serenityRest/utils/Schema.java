package co.com.proyectobase.serenityRest.utils;

public enum Schema {
    REQRES("data/schema/schemaGet.json");

    private String path;
    Schema(String path){this.path = path;}

    public static String getSchemaPath(String key){
        for (Schema schema: values()){
            if (schema.name().equalsIgnoreCase(key)){
                return schema.getSchema();
            }
        }
        throw new IllegalArgumentException("No schema found for key" + key);
    }
    public String getSchema(){return path;}
}
