package id.ac.umn.week11_36396;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostServices {
    @GET("posts")
    Call<List<PostModel>> getPosts();
}
