package saulodev.com.integrationproject.client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import saulodev.com.integrationproject.model.Cliente;

public interface Methods {

    @POST("/clientes")
    Call<Cliente> cadastrarUsuario(@Body Cliente cliente);

    @GET("/clientes/{id}")
    Call<Cliente> searchUser(@Path("id") Long id);

}
