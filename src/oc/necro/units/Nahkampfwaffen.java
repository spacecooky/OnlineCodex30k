package oc.necro.units;

import oc.BuildaHQ;
import oc.OnlineCodex;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerHelper;

public class Nahkampfwaffen extends RuestkammerHelper {

        String armee;
        boolean erstesSpiel = false;
        boolean boss = false;

        OptionsZaehlerGruppe oz1;
        OptionsZaehlerGruppe oz1a;

        public Nahkampfwaffen() {
                grundkosten = 0;
        }

        @Override
        public void initButtons(boolean... defaults) {
            armee = OnlineCodex.getInstance().getCurrentArmy();
            boss = defaults[0];


            ogE.addElement(new OptionsGruppeEintrag("Messer", 0, 5));
            (BuildaHQ.equals(armee, goliath) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Zweihandwaffe", "Zweihandaxt/ -keule/ -schwert", 10));
            (BuildaHQ.equals(armee, goliath, orlock, delaque, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Kette", "Kette/ Flegel", 10));
            (BuildaHQ.equals(armee, escher) ? ogE : ogEa).addElement(new OptionsGruppeEintrag("Schwert", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 25));
            add(oz1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
            setHeadline(oz1, "Nahkampfwaffen");

            seperator();

            ogEa.addElement(new OptionsGruppeEintrag("Keule", 10));
            ogEa.addElement(new OptionsGruppeEintrag("Energieaxt", 35));
            ogEa.addElement(new OptionsGruppeEintrag("Energiefaust", 85));
            ogEa.addElement(new OptionsGruppeEintrag("Energiestab", 35));
            ogEa.addElement(new OptionsGruppeEintrag("Energieschwert", 40));
            add(oz1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogEa));
            ogEa.clear();
            setHeadline(oz1a, "seltene Nahkampfwaffen");

            sizeSetzen();
        }

        @Override
        public void refreshen() {
            oz1a.setAktiv(!erstesSpiel);

            int anzahl = oz1.getAnzahl("Messer");
            oz1.setPreis("Messer", anzahl < 3 ? 0 : 5.0 * (anzahl - 1.0) / anzahl);

            if(erstesSpiel) {
                oz1.setAktiv("Kettenschwert", boss);
            } else
                oz1.setAktiv(true);
            }

            @Override
            public void specialVoid(boolean b) {
                erstesSpiel = b;
        }

}
