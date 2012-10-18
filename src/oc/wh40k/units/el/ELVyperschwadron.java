package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.wh40k.units.UncertainEldarCorsairAllies;

public class ELVyperschwadron extends UncertainEldarCorsairAllies {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsEinzelZaehler o2;
    OptionsEinzelZaehler o3;
    OptionsEinzelZaehler o4;
    OptionsEinzelZaehler o5;
    OptionsEinzelZaehler o6;

    public ELVyperschwadron() {
        name = "Vyperschwadron";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Vyper", "Vypern", 1, 3, 45);
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/Vyperschwadron.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Shurikenkanone", 5));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));
        ogE.addElement(new OptionsGruppeEintrag("Impulslaser", 15));
        ogE.addElement(new OptionsGruppeEintrag("Eldar-Raketenwerfer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sternenkanone", 25));
        ogE.addElement(new OptionsGruppeEintrag("Laserlanze", 30));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, squad.getModelle()));

        seperator();

        add(o6 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Shurikenkanone", squad.getModelle(), 10));

        seperator();

        add(o3 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Vektorschubdüsen", squad.getModelle(), 20));
        add(o4 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Zusatztriebwerke", squad.getModelle(), 15));
        add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Holofeld", squad.getModelle(), 35));
        add(o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Seelenstein", squad.getModelle(), 10));

        complete();
    }

    @Override
    public void refreshen() {
        super.refreshen();
        
        o1.setMaxAnzahl(squad.getModelle());
        o1x.setMaxAnzahl(squad.getModelle());
        o2.setMaxAnzahl(squad.getModelle());
        o3.setMaxAnzahl(squad.getModelle());
        o4.setMaxAnzahl(squad.getModelle());
        o5.setMaxAnzahl(squad.getModelle());
        o6.setMaxAnzahl(squad.getModelle());

        o1x.setAnzahl(0, o1x.getMaxAnzahl() - o1.getAnzahl());
    }
    
    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }
}
