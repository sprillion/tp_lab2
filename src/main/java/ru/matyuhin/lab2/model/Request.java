package ru.matyuhin.lab2.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {

    /***
     * Уникальный индентификатор сообщения
     */
    @NotBlank(message = "UID не может быть пустым")
    @Size(max = 32, message = "UID не может быть больше 32 символов")
    private String uid;
    /***
     * Уникальный индентификатор операции
     */
    @NotBlank(message = "operationUID не может быть пустым")
    @Size(max = 32, message = "operationUID не может быть больше 32 символов")
    private String operationUid;
    /***
     * Имя системы отправителя
     */
    private Systems systemName;
    /***
     * Время создания сообщения
     */
    @NotBlank(message = "systemTime не может быть пустым")
    private String systemTime;
    /***
     * Наименование ресурса
     */
    private String source;
    /***
     * Должность
     */
    private Positions position;
    /***
     * Зарплата
     */
    private Double salary;
    /***
     * Размер бонуса от зарплаты
     */
    private Double bonus;
    /***
     * Количество рабочих дней
     */
    private int workDays;
    /***
     * Уникальный идентификатор коммуникации
     */
    @Min(value = 1, message = "communicationId не может быть меньше 1")
    @Max(value = 100000, message = "communicationId не может быть больше 1")
    private int communicationId;
    /***
     * Уникальный идентификатор шаблона
     */
    private int templateId;
    /***
     * Код продукта
     */
    private int productCode;
    /***
     * Смс код
     */
    private int smsCode;

    @Override
    public String toString(){
        return "{" +
                "uid='" + uid + '\'' +
                ", operationUid='" + operationUid + '\'' +
                ", systemName='" + systemName + '\'' +
                ", systemTime='" + systemTime + '\'' +
                ", source='" + source + '\'' +
                ", communicationId='" + communicationId + '\'' +
                ", templateId='" + templateId + '\'' +
                ", productCode='" + productCode + '\'' +
                ", smsCode='" + smsCode + '\'' +
                '}';
    }
}