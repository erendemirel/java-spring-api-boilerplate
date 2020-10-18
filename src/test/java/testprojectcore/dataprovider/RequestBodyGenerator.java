package testprojectcore.dataprovider;

import com.google.gson.*;


//import com.torus.acquirerservice.dto.AcquirerRequestDto;
//import com.torus.merchantservice.dto.MerchantRequestDto;
//import com.torus.terminalservice.dto.TerminalDto;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequestBodyGenerator {

    /**
     * Custom serializer for LocalDate
     *
     */
    static class LocalDateAdapter implements JsonSerializer<LocalDate> {

        public JsonElement serialize(LocalDate date, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(date.format(DateTimeFormatter.ISO_LOCAL_DATE)); // "yyyy-mm-dd"
        }
    }

    /**
     * Register
     *
     */
    private static Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .create();
    }

/*    public static String generateCreateAcquirers() throws InterruptedException, IOException {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters()
                .randomize(FieldPredicates.ofType(Integer.class), new IntegerRandomizer(10));
        EasyRandom easyRandom = new EasyRandom();
        MerchantRequestDto merchantRequestDto = new MerchantRequestDto();
        merchantRequestDto = easyRandom.nextObject(MerchantRequestDto.class);
        Gson gson = getGson();
        String json = gson.toJson(merchantRequestDto);
        return json;
    }

    public static String generateCreateMerchantRequestBody() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters()
                .randomize(FieldPredicates.ofType(Integer.class), new IntegerRandomizer(10));
        EasyRandom easyRandom = new EasyRandom();
        MerchantRequestDto merchantRequestDto = new MerchantRequestDto();
        merchantRequestDto = easyRandom.nextObject(MerchantRequestDto.class);
        Gson gson = getGson();
        String json = gson.toJson(merchantRequestDto);
        return json;
    }

    public static String generateCreateUserRequestBody() {
        EasyRandomParameters easyRandomParameters = new EasyRandomParameters()
                .randomize(FieldPredicates.ofType(Integer.class), new IntegerRandomizer(10));
        EasyRandom easyRandom = new EasyRandom();
        UserDto userDto = new UserDto();
        userDto = easyRandom.nextObject(UserDto.class);
        Gson gson = getGson();
        String json = gson.toJson(userDto);
        return json;
    }

    public static String generateTerminalCreateRequestBody() {
        EasyRandom easyRandom = new EasyRandom();
        TerminalDto terminalDto = new TerminalDto();
        terminalDto = easyRandom.nextObject(TerminalDto.class);
        Faker faker = new Faker();
        String acquirerTerminalID = String.valueOf(faker.number().numberBetween(0, 34));
        terminalDto.setAcquirerTerminalNumber(acquirerTerminalID);
        Gson gson = getGson();
        String json = gson.toJson(terminalDto);
        return json;
    }*/
}
