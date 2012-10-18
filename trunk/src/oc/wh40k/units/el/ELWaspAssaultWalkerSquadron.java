package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ELWaspAssaultWalkerSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsEinzelUpgrade o6;

    public ELWaspAssaultWalkerSquadron() {
        name = "Wasp Assault Walker Squadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Wasp Assault Walker", 1, 3, 40);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ELWaspAssaultWalker.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 5));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * squad.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2 * squad.getModelle()));

        seperator();

        add(o6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Seelensteine", 5));

        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle() * 2);
        o1x.setMaxAnzahl(squad.getModelle() * 2);

        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());

        o6.setPreis(5 * squad.getModelle());
    }
}
