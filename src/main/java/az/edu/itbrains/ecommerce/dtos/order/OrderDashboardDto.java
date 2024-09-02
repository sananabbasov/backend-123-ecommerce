package az.edu.itbrains.ecommerce.dtos.order;


import az.edu.itbrains.ecommerce.dtos.user.UserInfoDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDashboardDto {
    private Long id;
    private String phoneNumber;
    private String address;
    private String message;
    private UserInfoDto user;
    private List<OrderDetailDto> orderItems = new ArrayList<>();
}
