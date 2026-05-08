package Classes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class SerializadorJSONMusica {

    private Gson gson;

    public SerializadorJSONMusica() {
        gson = new Gson();
    }

    // SERIALIZA lista -> JSON
    public String toJSON(List<Musica> listaMusicas) {
        return gson.toJson(listaMusicas);
    }

    // DESSERIALIZA JSON -> lista
    public List<Musica> fromJSON(String json) {

        Type tipoLista = new TypeToken<List<Musica>>(){}.getType();

        return gson.fromJson(json, tipoLista);
    }
}
