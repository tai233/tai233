package com.raven.domainModel;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "ChatLieu")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ChatLieu implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "MaChatLieu", unique = true)
    private String maChatLieu;

    @Column(name = "TenChatLieu")
    private String tenChatLieu;
}
