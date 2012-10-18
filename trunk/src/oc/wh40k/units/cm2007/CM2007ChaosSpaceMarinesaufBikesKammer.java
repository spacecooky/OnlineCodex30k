
package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class CM2007ChaosSpaceMarinesaufBikesKammer extends RuestkammerVater {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
        OptionsUpgradeGruppe o1;

        boolean child;

	public CM2007ChaosSpaceMarinesaufBikesKammer() {
            grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {

            try {
                child = defaults[0]; //Emperor's Children
            } catch(Exception e) {}
            
            name = "Chaos Space Marines auf Bikes";
            grundkosten = 0;

            squad = new AnzahlPanel(ID, randAbstand, cnt, "Chaos Biker", 3, 10, 33, "Chaos Space Marines auf Bikes");
            add(squad);

            add(ico = new oc.Picture("oc/wh40k/images/ChaosBikers.gif"));
            

            seperator();

            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone d. Glorreichen Chaos", "Ikone des Glorreichen Chaos", 10));
            ogE.addElement(new OptionsGruppeEintrag("Ikone des Slaanesh", child ? 0 : 20));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Khorne", 30));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Nurgle", 50));
            if(!child) ogE.addElement(new OptionsGruppeEintrag("Ikone des Tzeentch", 40));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
            if(child) ogE.addElement(new OptionsGruppeEintrag("Schockbooster", 10));
            ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
            add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();

            rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "CMChampion", "Upgrade zum Chaosbike Champion", 2);
            rkBoss.setGrundkosten(15);
            rkBoss.initKammer(false, false, true, false, true);
            rkBoss.setButtonText("Chaosbike Champion", false);
            rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
            add(rkBoss);

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            if(child) o1.alwaysSelected();
	}

}
