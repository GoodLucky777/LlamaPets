package net.lldv.llamapets.components.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.lldv.llamapets.components.forms.FormWindows;
import net.lldv.llamapets.components.provider.Provider;

@AllArgsConstructor
@Getter
public class API {

    private final Provider provider;
    private final FormWindows formWindows;

}
