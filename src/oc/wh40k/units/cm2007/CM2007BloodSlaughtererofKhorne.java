package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class CM2007BloodSlaughtererofKhorne extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o1a;
    AnzahlPanel squad;

	public CM2007BloodSlaughtererofKhorne() {
		name = "Blood Slaughterer of Khorne";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/CMBloodSlaughtererofKhorne.jpg"));

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Blood Slaughterer of Khorne", "Blood Slaughterers of Khorne", 1, 3, 130));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Zwei Cybot-NKWs", "Zwei Cybot-Nahkampfwaffen", 0));
        add(o1a = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("NKW + Impaler", "Cybot-Nahkampfwaffe + Impaler", 5));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());
        o1a.setMaxAnzahl(squad.getModelle());
        o1a.setAnzahl(0, squad.getModelle() - o1.getAnzahl());
//        if(oc.OnlineCodex.getInstance().getCurrentArmy().equals("ChaosSpaceMarines"))
//            if(BuildaHQ.getCountFromInformationVector("CMBerserker") > 0)
//                setFehlermeldung("");
//            else
//                setFehlermeldung("Zu wenig Berserker");
	}

}
