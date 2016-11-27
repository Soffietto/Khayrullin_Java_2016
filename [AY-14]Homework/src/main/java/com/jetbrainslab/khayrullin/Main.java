package com.jetbrainslab.khayrullin;

import com.jetbrainslab.khayrullin.database.*;
import com.jetbrainslab.khayrullin.entity.*;
import com.jetbrainslab.khayrullin.enums.*;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner in = new Scanner(System.in);

        UserDAO userDAO = null;
        NewsDAO newsDAO = null;
        CommunityDAO communityDAO = null;
        MessageDAO messageDAO = null;
        RequestDAO requestDAO = null;

        User user=null;
        Message message=null;
        Request request=null;
        Community community = null;
        News news=null;

        boolean checker = true;
        String option = null;
        int report = 0;

        while (checker){
            option = null;
            System.out.println("Выберете опцию " );
            System.out.println("[Добавить пользователя, добавить сообщение, добавить заявку]");
            System.out.println("[Редактировать сообщество, редактировать новость]");
            System.out.println("[Посмотреть отчёт]");
            option = in.nextLine();
            switch (option){
                case "Добавить пользователя":
                    userDAO = new UserDAO();
                    user = new User();
                    System.out.println("Введите имя пользователя:");
                    user.setName(in.nextLine());
                    System.out.println("Введите фамилию:");
                    user.setSurname(in.nextLine());
                    System.out.println("Введите email: ");
                    user.setEmail(in.nextLine());
                    System.out.println("Введите пароль: ");
                    user.setPassword(in.nextLine());
                    System.out.println("Введите роль[ROLE_USER, ROLE_ADMIN]");
                    user.setRole(Role.valueOf(in.nextLine()));
                    System.out.println("Введите статус пользователя[ACTIVE, BANNED]");
                    user.setUserStatus(UserStatus.valueOf(in.nextLine()));
                    userDAO.addUser(user);
                    System.out.println("Пользователь добавлен");
                    userDAO = null;
                    user = null;
                    break;
                case "Добавить сообщение":
                    messageDAO = new MessageDAO();
                    message = new Message();
                    System.out.println("Введите текст сообщения: ");
                    message.setText(in.nextLine());
                    System.out.println("Введите id отправителя: ");
                    message.setSenderId(in.nextInt());
                    System.out.println("Введите id получателя: ");
                    message.setRecipientId(in.nextInt());
                    in.nextLine();
                    System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]");
                    message.setCreatedAt(Timestamp.valueOf(in.nextLine()));
                    System.out.println("Введите статус сообщения[READ, NEW]");
                    message.setMessageStatus(MessageStatus.valueOf(in.nextLine()));
                    messageDAO.addMessage(message);
                    System.out.println("Сообщение добавлено");
                    messageDAO = null;
                    message = null;
                    break;
                case "Добавить заявку":
                    requestDAO = new RequestDAO();
                    request = new Request();
                    System.out.println("Введите id нуждающегося: ");
                    request.setNeedyId(in.nextInt());
                    System.out.println("Введите id волонтёра: ");
                    request.setVolonteerId(in.nextInt());
                    in.nextLine();
                    System.out.println("Введите адрес: ");
                    request.setAddress(in.nextLine());
                    System.out.println("Введите широту: ");
                    request.setLatitude(in.nextLong());
                    System.out.println("Введите долготу: ");
                    request.setLongitude(in.nextLong());
                    in.nextLine();
                    System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
                    request.setCreatedAt(Timestamp.valueOf(in.nextLine()));
                    System.out.println("Выберете тип[HOME, MARKET, STREET]");
                    request.setServiceType(ServiceType.valueOf(in.nextLine()));
                    System.out.println("Введите статус заявки[PENDING, CLOSED, ACTIVE]: ");
                    request.setRequestStatus(RequestStatus.valueOf(in.nextLine()));
                    requestDAO.addRequest(request);
                    System.out.println("Заявка добавлена");
                    requestDAO = null;
                    request = null;
                    break;
                case "Редактировать сообщество":
                    communityDAO = new CommunityDAO();
                    community = new Community();
                    System.out.println("Введите новое имя сообщества: ");
                    community.setName(in.nextLine());
                    System.out.println("Введите новое описание: ");
                    community.setDescription(in.nextLine());
                    System.out.println("Введите новое id основателя: ");
                    community.setFounderID(in.nextInt());
                    in.nextLine();
                    System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
                    community.setCreatedAt(Timestamp.valueOf(in.nextLine()));
                    System.out.println("Введите id сообщества, которое хотите изменить: ");
                    communityDAO.editCommunity(community, in.nextInt());
                    in.nextLine();
                    System.out.println("Сообщество успешно изменено");
                    community = null;
                    communityDAO = null;
                    break;
                case "Редактировать новость":
                    newsDAO = new NewsDAO();
                    news = new News();
                    System.out.println("Введите новый текст новости: ");
                    news.setText(in.nextLine());
                    System.out.println("Введите новый id сообщества: ");
                    news.setCommunityId(in.nextInt());
                    System.out.println("Введите новый id автора: ");
                    news.setAuthorId(in.nextInt());
                    in.nextLine();
                    System.out.println("Введите дату и время в формате [yyyy-MM-dd hh:mm:ss]: ");
                    news.setCreatedAt(Timestamp.valueOf(in.nextLine()));
                    System.out.println("Введите id новости которую хотите изменить: ");
                    newsDAO.editNews(news, in.nextInt());
                    in.nextLine();
                    System.out.println("Новость успешно изменена");
                    newsDAO = null;
                    news = null;
                    break;
                case "Посмотреть отчёт":
                    System.out.println("Выберете нужный отчёт");
                    System.out.println("[1 - Суммарное число новостей во всех сообществах, основанных каким-то пользователем]");
                    System.out.println("[2 - Пользовател(ь-и), получивши(й-е) больше всего сообщений за какой-то сезон (зима, весна, лето, осень)]");
                    System.out.println("[3 - Пользовател(ь-и), откликнувши(й-е)ся на наибольшее число заявок, которые были поданы по адресу, содержащему какой-то набор символов]");
                    report = in.nextByte();
                    switch (report){
                        case 1:
                            newsDAO = new NewsDAO();
                            System.out.println("Введите id нужного пользователя: ");
                            System.out.println(newsDAO.getMessageCountByUser(in.nextInt()));
                            in.nextLine();
                            newsDAO = null;
                            break;
                        case 2:
                            userDAO = new UserDAO();
                            System.out.println("Введите нужный сезон[SUMMER, WINTER, SPRING, AUTUMN]");
                            in.nextLine();
                            userDAO.usersWithMostMessagesOnSeason(in.nextLine());
                            userDAO = null;
                            break;
                        case 3:
                            userDAO = new UserDAO();
                            System.out.println("Введите нужный набор символов: ");
                            in.nextLine();
                            userDAO.usersWithMostAnswersWithAddressPart(in.nextLine());
                            userDAO = null;
                            break;
                        default:
                            System.out.println("Неверный номер отчёта!");
                            break;
                    }
                    break;
                default:
                    System.out.println("Неверная опция!");
                    break;
            }
            System.out.println("Хотите продолжить?");
            if(in.nextLine().equals("Нет"))
                checker = false;
        }
    }
}
