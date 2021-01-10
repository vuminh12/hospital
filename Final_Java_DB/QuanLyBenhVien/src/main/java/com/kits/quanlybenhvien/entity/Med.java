package com.kits.quanlybenhvien.entity;

import com.sun.istack.internal.NotNull;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Med {
    @Id
    private String nameMed;

    @NonNull
    private float price;
    @NotNull
    private String usedFor;

}
