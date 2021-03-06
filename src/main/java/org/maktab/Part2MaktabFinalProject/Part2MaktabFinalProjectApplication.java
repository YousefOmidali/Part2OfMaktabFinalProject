package org.maktab.Part2MaktabFinalProject;

import org.hibernate.engine.jdbc.BlobProxy;
import org.maktab.Part2MaktabFinalProject.entity.*;
import org.maktab.Part2MaktabFinalProject.entity.exceptions.WrongPriceEntered;
import org.maktab.Part2MaktabFinalProject.services.*;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.*;

@SpringBootApplication
public class Part2MaktabFinalProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(Part2MaktabFinalProjectApplication.class, args);
    }

    @Component
    class OnStartup implements ApplicationRunner {

        public OnStartup(AcceptedOrderService acceptedOrderService, AdminService adminService, CommentService commentService, CustomerService customerService, ExpertsService expertsService, OrderService orderService, ServiceService serviceService, SubServiceService subServiceService, SuggestionService suggestionService, WalletService walletService) {
            this.acceptedOrderService = acceptedOrderService;
            this.adminService = adminService;
            this.commentService = commentService;
            this.customerService = customerService;
            this.expertsService = expertsService;
            this.orderService = orderService;
            this.serviceService = serviceService;
            this.subServiceService = subServiceService;
            this.suggestionService = suggestionService;
            this.walletService = walletService;
        }

        private final AcceptedOrderService acceptedOrderService;
        private final AdminService adminService;
        private final CommentService commentService;
        private final CustomerService customerService;
        private final ExpertsService expertsService;
        private final OrderService orderService;
        private final ServiceService serviceService;
        private final SubServiceService subServiceService;
        private final SuggestionService suggestionService;
        private final WalletService walletService;


        @Override
        public void run(ApplicationArguments args) {
            Suggestion suggestion = null;
            Suggestion suggestion1 = null;
            adminService.saveOrUpdate(new Admin("Yousef", "Omidali", "@"
                    , "a", "Password00@", UserStatus.NEW, String.valueOf(LocalDateTime.now())));

            Wallet wallet = walletService.saveOrUpdate(new Wallet(100L));
            Wallet wallet2 = walletService.saveOrUpdate(new Wallet(0L));

            Customer customer = customerService.saveOrUpdate(new Customer("Yousef", "Omidali", "@"
                    , "a", "Password00@", UserStatus.NEW
                    , String.valueOf(LocalDateTime.now()), wallet, new ArrayList<>()));


            Experts experts = expertsService.saveOrUpdate(new Experts("Ali", "mohammadi", "@"
                    , "a", "Password00@", UserStatus.NEW, String.valueOf(LocalDateTime.now())
                    , 0L, BlobProxy.generateProxy(expertsService.getImage("F:\\Wallpaper\\tiger .jpg"))
                    , new HashSet<>(), wallet2));


            Service service = serviceService.saveOrUpdate(new Service("Nezafat"));
            SubService subService = subServiceService.saveOrUpdate(new SubService("nezafat manzel", 50L
                    , service, new HashSet<>()));
            subService.getExperts().add(experts);
            subServiceService.saveOrUpdate(subService);
            experts.getSubService().add(subService);
            expertsService.saveOrUpdate(experts);

            Order order = orderService.saveOrUpdate(new Order(customer, subService, String.valueOf(LocalDateTime.now())
                    , 50L, "Tehran", "2022-04-15"
                    , "Tehran, Azadi", OrderStatus.WaitingForExpertsSuggestion));

            System.out.println("*************** show all orders of an expert's subServices ***************");
            experts.getSubService()
                    .forEach(subServicesOfExpert -> orderService.allOrdersOfASubService(subServicesOfExpert)
                            .forEach(System.out::println));
            System.out.println("***************");

            try {
                suggestion = suggestionService.saveOrUpdate(new Suggestion(experts, order
                        , 55L, "5Days", "2022-4-16"));

                suggestion1 = suggestionService.saveOrUpdate(new Suggestion(experts, order
                        , 60L, "4Days", "2022-4-18"));
            } catch (WrongPriceEntered e) {
                System.out.println(e.getMessage());
            }


            order.setOrderStatus(OrderStatus.WaitingForCustomerToChooseASuggestion);
            orderService.saveOrUpdate(order);


            suggestionService.suggestionsOfAnOrder(order.getId()).forEach(System.out::println);

            acceptedOrderService.saveOrUpdate(new AcceptedOrder(order, suggestion));

            order.setOrderStatus(OrderStatus.ThisOrderIsChooseByAnExpert);
            orderService.saveOrUpdate(order);



        }

    }
}
