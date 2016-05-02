package mobile.silong.mvvm.data.api;

/**
 * Created by SILONG on 5/2/16.
 */
public class BaseResponse<T> {

  int code;

  String status;

  T data;

  public int getCode() {
    return code;
  }

  public String getStatus() {
    return status;
  }

  public T getData() {
    return data;
  }
}
