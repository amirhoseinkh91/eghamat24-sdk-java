import entities.*;
import org.springframework.http.MediaType;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import response.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author amir
 * @since 11/9/19
 */
@SuppressWarnings("Duplicates")
public class Eghamat24Api {

    private final String clientToken;
    private final int versionNumber;
    private final String host;
    private MediaType contentType = MediaType.APPLICATION_JSON;
    private RestTemplate restTemplate;
    private final String baseUrl;

    public Eghamat24Api(String clientToken, String host, MediaType contentType, int versionNumber, RestTemplate restTemplate) {
        this.clientToken = clientToken;
        this.host = host;
        this.contentType = contentType;
        this.versionNumber = versionNumber;
        this.restTemplate = restTemplate;
        baseUrl = generateBaseURL();

    }

    public Eghamat24Api(String clientToken, String host, int versionNumber, RestTemplate restTemplate) {
        this.clientToken = clientToken;
        this.host = host;
        this.versionNumber = versionNumber;
        this.restTemplate = restTemplate;
        baseUrl = generateBaseURL();
    }

    private String generateBaseURL() {
        return host + "/" + "v" + versionNumber + "/";
    }

    // Requests goes here
    public CitiesListResponse getCitiesList(@Nullable Integer page, @Nullable Integer size) {
        final String url = baseUrl + "cities";
        Map<String, Integer> uriVars = new HashMap<>();
        if (page != null)
            uriVars.put("offset", page);
        if (size != null)
            uriVars.put("count", size);
        ResponseSchema<CitiesListResponse> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public FacilitiesListResponse getFacilitiesList(@Nullable Integer page, @Nullable Integer size) {
        final String url = baseUrl + "facilities";
        Map<String, Integer> uriVars = new HashMap<>();
        if (page != null)
            uriVars.put("offset", page);
        if (size != null)
            uriVars.put("count", size);
        ResponseSchema<FacilitiesListResponse> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public PropertiesListResponse getPropertiesList(@Nullable Integer page, @Nullable Integer size, @Nullable Filter... filters) {
        final String url = baseUrl + "properties";
        Map<String, Object> uriVars = new HashMap<>();
        if (page != null)
            uriVars.put("offset", page);
        if (size != null)
            uriVars.put("count", size);
        if (filters != null && filters.length != 0)
            uriVars.put("filters", filters);
        ResponseSchema<PropertiesListResponse> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public Collection<RoomType> getRoomTypeList(@NonNull Integer propertyId) {
        final String url = baseUrl + "room-types";
        Map<String, Object> uriVars = new HashMap<>();
        if (propertyId != null)
            uriVars.put("property_id", propertyId);
        ResponseSchema<Collection<RoomType>> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public Collection<RoomRate> getAvailableRooms(@NonNull Integer propertyId, @NonNull Date checkIn, @NonNull Date checkOut) {
        final String url = baseUrl + "room-types";
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Map<String, Object> uriVars = new HashMap<>();
        uriVars.put("property_id", propertyId);
        uriVars.put("check_in", dateFormat.format(checkIn));
        uriVars.put("check_out", dateFormat.format(checkOut));
        ResponseSchema<Collection<RoomRate>> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public Collection<Suggestion> getSuggestion(@NonNull Integer cityId, @Nullable Integer propertyId,
                                                @NonNull Date checkIn, @NonNull Date checkOut,
                                                @Nullable Integer roomsCount, @NonNull Integer adultsCount,
                                                @Nullable Collection<Integer> childrensAges, @Nullable Filter... filters) {
        final String url = baseUrl + "suggestion";
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Map<String, Object> uriVars = new HashMap<>();
        uriVars.put("city_id", cityId);
        if (propertyId != null)
            uriVars.put("property_id", propertyId);
        uriVars.put("check_in", dateFormat.format(checkIn));
        uriVars.put("check_out", dateFormat.format(checkOut));
        if (roomsCount != null)
            uriVars.put("rooms_count", roomsCount);
        uriVars.put("adults_count", adultsCount);
        if (!CollectionUtils.isEmpty(childrensAges))
            uriVars.put("children", childrensAges);
        if (filters != null && filters.length != 0)
            uriVars.put("filters", filters);
        ResponseSchema<Collection<Suggestion>> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails reserve(@NonNull Reserve reserve) {
        final String url = baseUrl + "reserve";
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, reserve, ResponseSchema.class, new HashMap<>());
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails book(@NonNull String confirmationCode) {
        final String url = baseUrl + "book";
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, confirmationCode, ResponseSchema.class, new HashMap<>());
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails cancel(@NonNull String confirmationCode) {
        final String url = baseUrl + "cancel";
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, confirmationCode, ResponseSchema.class, new HashMap<>());
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails acceptCancelReserve(@NonNull String reserveConfirmationCode) {
        final String url = baseUrl + "accept-cancel/{reserve_confirmation_code}";
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("reserve_confirmation_code", reserveConfirmationCode);
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, null, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails rejectCancelReserve(@NonNull String reserveConfirmationCode) {
        final String url = baseUrl + "reject-cancel/{reserve_confirmation_code}";
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("reserve_confirmation_code", reserveConfirmationCode);
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, null, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails modifyReserve(@NonNull String reserveConfirmationCode, @NonNull Reserve reserve) {
        final String url = baseUrl + "modify/{reserve_confirmation_code}";
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("reserve_confirmation_code", reserveConfirmationCode);
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, null, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetails acceptModifyReserve(@NonNull String reserveConfirmationCode, @NonNull Reserve reserve) {
        final String url = baseUrl + "accept-modify/{reserve_confirmation_code}";
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("reserve_confirmation_code", reserveConfirmationCode);
        ResponseSchema<ReserveDetails> responseSchema = restTemplate.postForObject(url, null, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReservesListResponse getReservesList(@Nullable Integer size, @Nullable Integer page, @Nullable Filter... filters) {
        final String url = baseUrl + "reserves";
        Map<String, Object> uriVars = new HashMap<>();
        if (size != null)
            uriVars.put("count", size);
        if (page != null)
            uriVars.put("page", page);
        if (filters != null && filters.length != 0)
            uriVars.put("filters", filters);
        ResponseSchema<ReservesListResponse> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public ReserveDetailsResponse getReserve(@NonNull String confirmationCode) {
        final String url = baseUrl + "reserve-details";
        Map<String, String> uriVars = new HashMap<>();
        uriVars.put("confirmation_code", confirmationCode);
        ResponseSchema<ReserveDetailsResponse> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, uriVars);
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    public Profile getProfile() {
        final String url = baseUrl + "profile";
        ResponseSchema<Profile> responseSchema = restTemplate.getForObject(url, ResponseSchema.class, new HashMap<>());
        return Optional.of(responseSchema).orElse(new ResponseSchema<>()).getValue();
    }

    // TODO: 11/11/19 WEB Hook Parts (page 21)


}
