package oc.wh40k.units.rh;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class RHSabreGunPlatformBatteryKammer extends RuestkammerVater {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;

	public RHSabreGunPlatformBatteryKammer() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
    	
    	squad = new AnzahlPanel(ID, randAbstand, cnt, "Sabre Gun", "Sabre Guns", 1, 3, 20);
		squad.setGrundkosten(0);
		add(squad);
    	
		add(ico = new oc.Picture("oc/wh40k/images/RHSabreGunPlatformBatteryKammer.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters","Twin-linked heavy bolters", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 TL Heavy stubbers","2 twin-linked heavy stubbers", 10));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannons","Twin-linked autocannons", 10));
		ogE.addElement(new OptionsGruppeEintrag("TL lascannons","Twin-linked lascannons", 20));
		ogE.addElement(new OptionsGruppeEintrag("TL Heavy bolters (AA)","Twin-linked heavy bolters (AA mount)", 10));
		ogE.addElement(new OptionsGruppeEintrag("2 TL Heavy stubbers (AA)","2 twin-linked heavy stubbers (AA mount)", 20));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannons (AA)","Twin-linked autocannons (AA mount)", 20));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
    	o1.setMaxAnzahl(squad.getModelle());
		o1.setLegal(o1.getAnzahl()==o1.getMaxAnzahl());
	}

}
