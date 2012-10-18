package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ELKampflaeuferschwadron extends Eintrag {

    AnzahlPanel Kampflaeuferschwadron;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsEinzelZaehler o6;

    public ELKampflaeuferschwadron() {

        name = "Kampflaeuferschwadron";

        grundkosten = 0;

        add(Kampflaeuferschwadron = new AnzahlPanel(ID, randAbstand, cnt, "Kampfläufer", 1, 3, 30));

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ELKampflaeuferschwadron.jpg"));
        

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 5));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * Kampflaeuferschwadron.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * Kampflaeuferschwadron.getModelle()));

        seperator();

        add(o6 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Seelensteine", Kampflaeuferschwadron.getModelle(), 5));

        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(Kampflaeuferschwadron.getModelle() * 2);
        o1x.setMaxAnzahl(Kampflaeuferschwadron.getModelle() * 2);
        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());

        o6.setMaxAnzahl(Kampflaeuferschwadron.getModelle());
    }
    
}
