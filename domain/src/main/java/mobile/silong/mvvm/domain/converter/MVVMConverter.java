package mobile.silong.mvvm.domain.converter;

/**
 * Created by SILONG on 4/13/16.
 */
public interface MVVMConverter<F, T> {

  T convert(F from);
}
