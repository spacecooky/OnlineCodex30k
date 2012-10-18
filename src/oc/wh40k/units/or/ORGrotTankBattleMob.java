package oc.wh40k.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ORGrotTankBattleMob extends Eintrag {

	AnzahlPanel GrotTank;
	OptionsEinzelUpgrade Kommanda;
	OptionsZaehlerGruppe KommandaFK;
	OptionsEinzelUpgrade KommandaShoota;
	OptionsZaehlerGruppe GrotTankFK;
	OptionsEinzelZaehler Shoota;
	OptionsEinzelUpgrade RPJ;

	public ORGrotTankBattleMob() {

		kategorie = 2;
		grundkosten = 0;
		GrotTank = new AnzahlPanel(ID, randAbstand, cnt, "", "Grot Tanks", 3, 6, 30);
		add(GrotTank);

		add(ico = new oc.Picture("oc/wh40k/images/Killabot.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grotzooka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 20));
		GrotTankFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1);
		add(GrotTankFK);
		
		seperator();

		add(Shoota = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "pintle-mounted Shoota",GrotTank.getModelle(), 5)); 
		
		seperator();
		
		add(Kommanda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kommanda", 15));

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Grotzooka", 10));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 20));
		KommandaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2);
		add(KommandaFK);
		
		seperator();
		
		add(KommandaShoota = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "pintle-mounted Shoota", 5)); 
		
		seperator(15);
		
		add(RPJ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5*GrotTank.getModelle())); 
		
		BuildaHQ.addToInformationVector("ORGrotTankBattleMob", 1);
		BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("[IA Apocalypse 2nd Ed] Grot Mega Tank");
		
		complete();

	}

	@Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("ORGrotTankBattleMob", -1);
        if(BuildaHQ.getCountFromInformationVector("ORGrotTankBattleMob") <= 0) {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("[IA Apocalypse 2nd Ed] Grot Mega Tank");
        }
        super.deleteYourself();
    }
	
	//@OVERRIDE
	public void refreshen() {


		if(!Kommanda.isSelected()){
		GrotTankFK.setMaxAnzahl(GrotTank.getModelle());
		Shoota.setMaxAnzahl(GrotTank.getModelle());
		GrotTankFK.setLegal(GrotTank.getModelle() == GrotTankFK.getAnzahl());
		
		KommandaFK.setAktiv(false);
		KommandaShoota.setAktiv(false);
		
		} else{
			
			GrotTankFK.setMaxAnzahl(GrotTank.getModelle()-1);
			Shoota.setMaxAnzahl(GrotTank.getModelle()-1);
			GrotTankFK.setLegal(GrotTank.getModelle()-1 == GrotTankFK.getAnzahl());
			
			KommandaFK.setAktiv(true);
			KommandaShoota.setAktiv(true);
			
			KommandaFK.setLegal(KommandaFK.getAnzahl() == 2);
			
		}
		
		RPJ.setPreis(GrotTank.getModelle() * 5);
	}
}

