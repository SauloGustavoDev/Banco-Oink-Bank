package saulodev.com.integrationproject.client;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import saulodev.com.integrationproject.model.Cliente;

public interface Methods {

    @POST("/clientes")
    Call<Cliente> cadastrarUsuario(@Body Cliente cliente);

}
