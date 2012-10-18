package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAGeistKampfanzugteam extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelZaehler o2;
    OptionsZaehlerGruppe o3;
    RuestkammerStarter ob1;
    RuestkammerStarter ob2;

    public TAGeistKampfanzugteam() {
        name = "Geist Kampfanzugteam\n";
        grundkosten = 0;
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Geist-Kampfanzüge", 3, 6, 30);
        add(squad);

        BuildaHQ.addToInformationVector("TA2006GeistKampfanzugteam", 1);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/GeistKampfanzugteam.gif"));
        

        add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Fusionsblaster", squad.getModelle() / 3, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stabilisatorsystem", 10));
        ogE.addElement(new OptionsGruppeEintrag("Nachtsichtgerät", 3));
        ogE.addElement(new OptionsGruppeEintrag("Drohnencontroller", 0));
        ogE.addElement(new OptionsGruppeEintrag("Feuerleitsystem", 5));
        ogE.addElement(new OptionsGruppeEintrag("Schildgenerator", 20));
        ogE.addElement(new OptionsGruppeEintrag("Multiple Zielerfassung", 5));
        ogE.addElement(new OptionsGruppeEintrag("Verb. Zielerfassung", "Verbesserte Zielerfassung", 10));
        add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, squad.getModelle()));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
        ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
        ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
        add(o3 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 0));

        seperator();

        ob1 = new RuestkammerStarter(ID, randAbstand, cnt, "TAShasvreKammer", "Upgrade zum Teamführer");
        ob1.initKammer(false, true);
        add(ob1);

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, "TAShasvreKammer", "Upgrade zum Shas'vre");
        ob2.initKammer(true, true);
        ob2.setGrundkosten(10);
        add(ob2);

        complete();

    }

    @Override
    public void refreshen() {
        int modelle = squad.getModelle();
        o1.setMaxAnzahl(modelle);
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl() || !o1.isSelected());
        o2.setMaxAnzahl(modelle / 3);
        o3.setMaxAnzahl(o1.getAnzahl("Drohnencontroller") * 2);
        o3.setLegal(o3.getAnzahl() * 2 >= o3.getMaxAnzahl());
        ob1.setAktiv(!ob2.isSelected());
        ob2.setAktiv(!ob1.isSelected());
        String TFValue = (String) ((TAShasvreKammer) ob1.getKammer()).getSpecialValue();
        String ShasvreValue = (String) ((TAShasvreKammer) ob2.getKammer()).getSpecialValue();
        o1.setButtonMaxAnzahl("Drohnencontroller", (TFValue.equals("Kyb. Drohnencontroller") || ShasvreValue.equals("Kyb. Drohnencontroller")) ? modelle - 1 : modelle);
        ob1.getKammer().switchEntry("Kyb. Drohnencontroller", !(o1.getAnzahl("Drohnencontroller") == modelle));
        ob2.getKammer().switchEntry("Kyb. Drohnencontroller", !(o1.getAnzahl("Drohnencontroller") == modelle));

        // O'Shova Sonderregel beachten
        int currentUnitCount = BuildaHQ.getCountFromInformationVector("TA2006GeistKampfanzugteam");
        boolean oshova = BuildaHQ.getCountFromInformationVector("TA2006OShovah") == 0 ? false : true;
        if(oshova && currentUnitCount > 1) setFehlermeldung("0-1 wgegen O'Shova");
        else setFehlermeldung("");
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
        BuildaHQ.addToInformationVector("TA2006GeistKampfanzugteam", -1);
    }
    
}
