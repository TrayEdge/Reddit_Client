package app.st1ch.redditclient.data;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import app.st1ch.redditclient.domain.ErrorHandler;
import okhttp3.ResponseBody;
import retrofit2.adapter.rxjava.HttpException;

/**
 * Created by st1ch on 13.09.2016.
 */
public class ResponseErrorHandler implements ErrorHandler {
    private Gson gson = new Gson();

    @Override
    public String handleError(Throwable t) {
        String message = t.getMessage();
        if (t instanceof HttpException) {
            ResponseBody body = ((HttpException) t).response().errorBody();
            TypeAdapter<Error> adapter = gson.getAdapter(Error.class);
            try {
                Error error = adapter.fromJson(body.string());
                return error.getMessage();
            } catch (Exception e) {}
        }

        return message;
    }
}
