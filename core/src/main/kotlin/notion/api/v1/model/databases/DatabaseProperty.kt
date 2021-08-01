package notion.api.v1.model.databases

import notion.api.v1.model.common.*
import notion.api.v1.model.pages.Page
import notion.api.v1.model.users.User

open class DatabaseProperty(
    val type: PropertyType,
    val id: String,
    val name: String? = null,
    var title: RichText? = null,
    var richText: RichText? = null,
    var number: Number? = null,
    var select: Select? = null,
    var multiSelect: MultiSelect? = null,
    var date: Date? = null,
    var people: People? = null,
    var checkbox: Checkbox? = null,
    var url: Url? = null,
    var phoneNumber: PhoneNumber? = null,
    var relation: Relation? = null,
    var rollup: Rollup? = null,
    var email: Email? = null,
    var files: Files? = null,
    var formula: Formula? = null,
    val createdBy: CreatedBy? = null,
    val lastEditedBy: LastEditedBy? = null,
    val createdTime: CreatedTime? = null,
    val lastEditedTime: LastEditedTime? = null,
) {
  constructor(
      type: PropertyType,
      id: String,
  ) : this(
      type,
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
  )

  open class RichText(
      var type: RichTextType = RichTextType.Text,
      var text: Text? = null,
      var annotations: Annotations? = null,
      var plainText: String = "",
      var href: String? = null,
      val mention: Mention? = null,
  ) {

    open class Text(var content: String? = null, var link: Link? = null)

    open class Link(var type: RichTextLinkType? = null, var url: String? = null)

    open class Annotations(
        var bold: Boolean? = null,
        var italic: Boolean? = null,
        var strikethrough: Boolean? = null,
        var underline: Boolean? = null,
        var code: Boolean? = null,
        var color: RichTextColor? = null,
    )
    open class Mention(
        var type: RichTextMentionType? = null,
        var user: User? = null,
        val page: Page? = null,
        val database: Database? = null,
        val date: Date? = null,
    )
  }

  open class Number(
      var format: String? = null,
  )

  open class Date(var start: String? = null, var end: String? = null)

  open class Relation(
      var databaseId: String? = null,
      var syncedPropertyName: String? = null,
      var syncedPropertyId: String? = null,
  )

  open class Rollup(
      var relationPropertyName: String? = null,
      var relationPropertyId: String? = null,
      var rollupPropertyName: String? = null,
      var rollupPropertyId: String? = null,
      var function: String? = null,
  )

  class People

  class Checkbox

  class Url

  class Files

  class PhoneNumber

  class Email

  open class Formula(var expression: String? = null)

  open class MultiSelect(var options: List<Option>? = null) {
    open class Option(
        var id: String? = null,
        var name: String? = null,
        var color: OptionColor? = null,
    )
  }

  data class Select(val options: List<Option>? = null) {
    data class Option(
        val id: String? = null,
        val name: String? = null,
        val color: OptionColor? = null,
    )
  }

  class CreatedBy

  class LastEditedBy

  class CreatedTime

  class LastEditedTime
}
